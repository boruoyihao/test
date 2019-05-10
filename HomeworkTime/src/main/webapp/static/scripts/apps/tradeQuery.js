define(function(require) {
    var $ = require('jquery'),
        ui = require('jquery-ui'),
        hbs = require('handlebars'),
        hbsHelper = require('./tradeQueryHelper'),
        tmpl = require('templates'),
        validator = require('modules/form/validator'),
        util = require('modules/form/util'),
        modalFactory = require('modules/modalFactory');

    var currentPage = 1;
    var tbCon = $('.query-result-table'),
        form = $('.form-trade-query');

    // 初始化表单验证
    validator = new validator(form, {
        type: 'get'
    });

    // 设置当前页码
    function setPage(page) {
        currentPage = page;
        $('[name="pageNo"]').val(page);
    }
    function flipPage(nav) {
        if(nav.hasClass('disabled')) return;
        var currpage = parseInt($('.pagination .active').find('a').html()),
            direction = nav.find('span').html();

        if(direction === '«') setPage(--currpage);
        else if(direction === '»') setPage(++currpage);

        form.trigger('submit');
    }

    // 事件绑定
    function bindEvents() {
        // 重置事件
        $('.form-reset').on('click', function(e) {
            validator.getForm().get(0).reset();
        });

        // 点击查询重置页码
        $('[type="submit"]').on('mousedown', function(e) {
            setPage(1);
        });

        // 分页事件
        tbCon.on('click', '.pagination a', function(e) {
            var pageNo = $(this).html();
            setPage(parseInt(pageNo));
            form.trigger('submit');
        });
        // 上一页下一页
        tbCon.on('click', '.pagination li:first', function(e) {
            flipPage($(this));
        });
        tbCon.on('click', '.pagination li:last', function(e) {
            flipPage($(this));
        });

        // 导出结果
        tbCon.on('click', '#btn_export', function(e) {
            window.location.href = '/operation/downloadQuerylist?'+form.serialize();
        });
    }
    bindEvents();

    // 查询交易结果，并渲染表格
    (function() {
        var renderTable = function(data) {
            var tpl = JIT['templates/queryResultTable.hbs'](data);
            tbCon.html(tpl);
        };

        validator.getForm().on('submit-success', function(e, data) {
            data['currentPage'] = currentPage;
            data['hasRecords'] = ((data.total === '0' || typeof data.total === 'undefined') ? false : true);
            renderTable(data);
        });
    })();


    // 初始化日历组件
    (function() {
        var domStartDate = $('#start_date'),
            domEndDate = $('#end_date'),
            now = new Date(),
            startDate = new Date(now.getFullYear(), now.getMonth(), now.getDate()-10);

        domStartDate.val(util.formatDate(startDate));
        domEndDate.val(util.formatDate(now));

        domStartDate.datepicker({
            // minDate: minDate,
            maxDate: now,
            dateFormat: "yy-mm-dd",
            onClose: function(selectedDate) {
                domEndDate.datepicker('option', 'minDate', selectedDate);
            }
        });
        domEndDate.datepicker({
            // minDate: minDate,
            maxDate: now,
            dateFormat: "yy-mm-dd",
            onClose: function(selectedDate) {
                domStartDate.datepicker('option', 'maxDate', selectedDate);
            }
        });
    })();

    // 设置"搜索条件"input name
    (function() {
        var searchSelect = $('#search_condition');
        searchSelect.on('change', function() {
            var condition = $(this).val(),
                searchInput = $(this).next();

            switch(condition) {
                case '交易号':
                    searchInput.attr('name', 'tradeId');
                    break;

                case '外部订单号':
                    searchInput.attr('name', 'orderId');
                    break;

                case '小米ID':
                    searchInput.attr('name', 'miId');
                    break;

                default:
                    searchInput.attr('name', '');
                    break;
            }
        });
    })();

    //  退款
    (function() {
        function rollback(btn) {
            var tr = btn.parents('tr'),
                tdlist = $('td', tr);
                tradeId = tdlist.eq(0).html(),
                orderId = tdlist.eq(3).html(),
                amount = tdlist.eq(5).html(),
                queryData = 'tradeId='+tradeId+'&orderId='+orderId+'&amount='+parseFloat(amount)*100;

            util.sendAjax('post', '/operation/refund', queryData, function(data) {
                if(data.code === 200) {
                    tdlist.eq(4).html('退款中...');
                    tdlist.eq(7).find('button').attr('disabled', true);
                }
            });
        }
        tbCon.on('click', 'td button', function(e) {
            var btn = $(this);
            new modalFactory({
                title: '退款',
                content: '确定要退款吗？',
                confirmAction: function() {
                    rollback(btn);
                }
            });
        });
    })();

    // 交易状态
    (function() {
        var tradeStatusList = $('.tradeStatus'),
            tradeStatusListAry = tradeStatusList.toArray(),
            all = $('.tradeStatusAll'),
            statusAry = [];

        all.on('click', function() {
            tradeStatusList.prop('checked', $(this).prop('checked'));
        });

        function isAllChecked() {
            var allChecked = true;
            tradeStatusListAry.forEach(function(item) {
                allChecked = allChecked && $(item).prop('checked');
            });
            return allChecked;
        }

        tradeStatusList.on('click', function() {
            if(!$(this).prop('checked')) {
                all.prop('checked', false);
            } else if(isAllChecked()) {
                all.prop('checked', true);
            }
        });

        $('[type="submit"]').on('mousedown', function(e) {
            var vals = [];
            tradeStatusListAry.forEach(function(item) {
                if($(item).prop('checked')) vals.push($(item).val());
            });
            $('[name="tradeStatus"]').val(vals.join(','));
        });

    })();
});
