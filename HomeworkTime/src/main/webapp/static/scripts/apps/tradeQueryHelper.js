define(['jquery', 'handlebars'], function($, hbs) {

    var itemsPerPage = 30;
    Handlebars.registerHelper('renderTable', function(item) {
        var contents = [],
            rollbackContent = '--';

        for (var i = 0, len = item.length; i <len; i++) {
            contents.push('<td>'+item[i]+'</td>');
            if(i === 4 && item[i] === '付款成功') {
                rollbackContent = '<button class="btn btn-default">退款</button>';
            }
        }

        contents.push('<td>'+rollbackContent+'</td>');
        return new Handlebars.SafeString(contents.join(''));
    });

    Handlebars.registerHelper('renderPagination', function(currentPage, total) {
        var i,
            pageCount = Math.ceil(total/itemsPerPage),
            pageAry = [];

        pageAry.push('<li '+(currentPage===1?'class="disabled"':'')+'><span>&laquo;</span></li>');
        for(i = 0; i < pageCount; i++) {
            pageAry.push('<li '+(i+1===currentPage?'class="active"':'')+'><a href="#nogo">'+(i+1)+'</a></li>');
        }
        pageAry.push('<li '+(currentPage===pageCount?'class="disabled"':'')+'><span>&raquo;</span></li>');

        return new Handlebars.SafeString(pageAry.join(''));
    });

    Handlebars.registerHelper('currentRecords', function(currentPage, data) {
        var start = (currentPage-1)*itemsPerPage+1,
            end = start+data.length-1;

        return new Handlebars.SafeString(start+'-'+end);
    });

});
