this["JIT"] = this["JIT"] || {};

Handlebars.registerPartial("pagination", this["JIT"]["pagination"] = Handlebars.template(function (Handlebars,depth0,helpers,partials,data) {
  this.compilerInfo = [4,'>= 1.0.0'];
helpers = this.merge(helpers, Handlebars.helpers); data = data || {};
  var buffer = "", stack1, helper, options, helperMissing=helpers.helperMissing, escapeExpression=this.escapeExpression, functionType="function";


  buffer += "<div class=\"pagination-container\">\n    <p>显示第"
    + escapeExpression((helper = helpers.currentRecords || (depth0 && depth0.currentRecords),options={hash:{},data:data},helper ? helper.call(depth0, (depth0 && depth0.currentPage), (depth0 && depth0.data), options) : helperMissing.call(depth0, "currentRecords", (depth0 && depth0.currentPage), (depth0 && depth0.data), options)))
    + "条记录，共";
  if (helper = helpers.total) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.total); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "条记录</p>\n    <ul class=\"pagination\">\n        "
    + escapeExpression((helper = helpers.renderPagination || (depth0 && depth0.renderPagination),options={hash:{},data:data},helper ? helper.call(depth0, (depth0 && depth0.currentPage), (depth0 && depth0.total), options) : helperMissing.call(depth0, "renderPagination", (depth0 && depth0.currentPage), (depth0 && depth0.total), options)))
    + "\n    </ul>\n</div>\n";
  return buffer;
  }));

this["JIT"]["templates/modal/frame.hbs"] = Handlebars.template(function (Handlebars,depth0,helpers,partials,data) {
  this.compilerInfo = [4,'>= 1.0.0'];
helpers = this.merge(helpers, Handlebars.helpers); data = data || {};
  var buffer = "", stack1, helper, functionType="function", escapeExpression=this.escapeExpression;


  buffer += "<div class=\"modal\" tabindex=\"-1\" role=\"dialog\">\n    <div class=\"modal-dialog\">\n        <div class=\"modal-content\">\n            \n            <div class=\"modal-header\">\n                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\n                    <span aria-hidden=\"true\">&times;</span>\n                    <span class=\"sr-only\">关闭</span>\n                </button>\n                <h4 class=\"modal-title\" id=\"myModalLabel\">";
  if (helper = helpers.title) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.title); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "</h4>\n            </div>\n\n            <div class=\"modal-body\">\n                ";
  if (helper = helpers.content) { stack1 = helper.call(depth0, {hash:{},data:data}); }
  else { helper = (depth0 && depth0.content); stack1 = typeof helper === functionType ? helper.call(depth0, {hash:{},data:data}) : helper; }
  buffer += escapeExpression(stack1)
    + "\n            </div>\n\n            <div class=\"modal-footer\">\n                <button type=\"button\" class=\"btn btn-default btn-cancel\" data-dismiss=\"modal\">取消</button>\n                <button type=\"button\" class=\"btn btn-primary btn-confirm\">确定</button>\n            </div>\n\n        </div>\n    </div>\n</div>\n";
  return buffer;
  });

this["JIT"]["templates/queryResultTable.hbs"] = Handlebars.template(function (Handlebars,depth0,helpers,partials,data) {
  this.compilerInfo = [4,'>= 1.0.0'];
helpers = this.merge(helpers, Handlebars.helpers); partials = this.merge(partials, Handlebars.partials); data = data || {};
  var buffer = "", stack1, helperMissing=helpers.helperMissing, escapeExpression=this.escapeExpression, self=this;

function program1(depth0,data) {

  var buffer = "", stack1;
  buffer += "\n";
  stack1 = self.invokePartial(partials.pagination, 'pagination', depth0, helpers, partials, data);
  if(stack1 || stack1 === 0) { buffer += stack1; }
  buffer += "\n<table class=\"table table-striped\">\n    <thead>\n        <tr>\n            <th>交易号</th>\n            <th>交易时间</th>\n            <th>小米ID</th>\n            <th>外部订单号</th>\n            <th>交易状态</th>\n            <th>交易金额</th>\n            <th>手续费</th>\n            <th>退款</th>\n        </tr>\n    </thead>\n    <tbody>\n        ";
  stack1 = helpers.each.call(depth0, (depth0 && depth0.data), {hash:{},inverse:self.noop,fn:self.program(2, program2, data),data:data});
  if(stack1 || stack1 === 0) { buffer += stack1; }
  buffer += "\n    </tbody>\n</table>\n";
  stack1 = self.invokePartial(partials.pagination, 'pagination', depth0, helpers, partials, data);
  if(stack1 || stack1 === 0) { buffer += stack1; }
  buffer += "\n<button class=\"btn btn-lg btn-success\" id=\"btn_export\">查询结果导出</button>\n\n";
  return buffer;
  }
function program2(depth0,data) {

  var buffer = "", helper, options;
  buffer += "\n        <tr>\n            "
    + escapeExpression((helper = helpers.renderTable || (depth0 && depth0.renderTable),options={hash:{},data:data},helper ? helper.call(depth0, depth0, options) : helperMissing.call(depth0, "renderTable", depth0, options)))
    + "\n        </tr>\n        ";
  return buffer;
  }

function program4(depth0,data) {


  return "\n\n<h1 class=\"no-record\">抱歉，没有找到任何交易记录！</h1>\n\n";
  }

  stack1 = helpers['if'].call(depth0, (depth0 && depth0.hasRecords), {hash:{},inverse:self.program(4, program4, data),fn:self.program(1, program1, data),data:data});
  if(stack1 || stack1 === 0) { buffer += stack1; }
  buffer += "\n";
  return buffer;
  });
