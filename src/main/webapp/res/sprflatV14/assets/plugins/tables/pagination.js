/**
 * 
 * @author ZhangHuihua@msn.com
 * 
 * @param {Object}    opts Several options
 */

(function($) {
	var paginationFrag = "<ul class=\"pagination\">"
			+ "<li class=\"j-first\">" +
					"<a class=\"first\" href=\"javascript:;\"><span>首页</span></a>"
					+ "<span class=\"first\"><span>首页</span></span>"
			+ "</li>"
			+ "<li class=\"j-prev\">" +
					"<a class=\"previous\" href=\"javascript:;\"><span>上一页</span></a>"
					+ "<span class=\"previous\"><span>上一页</span></span>"
			+ "</li> "+
					"#pageNumFrag#"
			+ "<li class=\"j-next\">" +
					"<a class=\"next\" href=\"javascript:;\"><span>下一页</span></a>"
					+ "<span class=\"next\"><span>下一页</span></span>"
			+ "</li>" +
			"<li class=\"j-last\">"
				+ "<a class=\"last\" href=\"javascript:;\"><span>末页</span></a>"
				+ "<span class=\"last\"><span>末页</span></span>"
			+ "</li></ul>";

	$.fn.extend({
				pagination : function(opts) {
					var setting = {
						first$ : "li.j-first",
						prev$ : "li.j-prev",
						next$ : "li.j-next",
						last$ : "li.j-last",
						nums$ : "li.j-num>a",
						jumpto$ : "li.jumpto",
						pageNumFrag : '<li class="#liClass#"><a href="javascript:;">#pageNum#</a></li>'
					};
					return this.each(function() {
						var $this = $(this);
						var pc = new Pagination(opts);
						var interval = pc.getInterval();

						var pageNumFrag = '';
						for (var i = interval.start; i < interval.end; i++) {
							pageNumFrag += setting.pageNumFrag.replaceAll(
									"#pageNum#", i).replaceAll(
									"#liClass#",
									i == pc.getCurrentPage() ? 'active j-num'
											: 'j-num');
						}
						$this.html(
								paginationFrag.replaceAll("#pageNumFrag#",
										pageNumFrag).replaceAll(
										"#currentPage#", pc.getCurrentPage())).find("li");// .hoverClass();

						var $first = $this.find(setting.first$);
						var $prev = $this.find(setting.prev$);
						var $next = $this.find(setting.next$);
						var $last = $this.find(setting.last$);

						if (pc.hasPrev()) {
							$first.add($prev).find(">span").hide();
							_bindEvent($prev, pc.getCurrentPage() - 1, pc
									.targetType(), pc.rel());
							_bindEvent($first, 1, pc.targetType(), pc.rel());
						} else {
							$first.add($prev).addClass("disabled").find(">a")
									.hide();
						}

						if (pc.hasNext()) {
							$next.add($last).find(">span").hide();
							_bindEvent($next, pc.getCurrentPage() + 1, pc
									.targetType(), pc.rel());
							_bindEvent($last, pc.numPages(), pc.targetType(),
									pc.rel());
						} else {
							$next.add($last).addClass("disabled").find(">a")
									.hide();
						}

						$this.find(setting.nums$).each(
								function(i) {
									_bindEvent($(this), i + interval.start, pc
											.targetType(), pc.rel());
								});
						$this.find(setting.jumpto$).each(function() {
							var $this = $(this);
							var $inputBox = $this.find(":text");
							var $button = $this.find(":button");
							$button.click(function(event) {
								var pageNum = $inputBox.val();
								if (pageNum && pageNum.isPositiveInteger()) {
									pageBreak({
											data : {
											pageNum : pageNum
										}
									});
								}
							});
							$inputBox.keyup(function(event) {
								if (event.keyCode == 13)
									$button.click();
							});
						});
					});

					function _bindEvent($target, pageNum, targetType, rel) {
						$target.bind("click", {
							pageNum : pageNum
						}, function(event) {
							pageBreak({pageNum : event.data.pageNum});
							event.preventDefault();
						});
					}
				},

				orderBy : function(options) {
					var op = $.extend({
						targetType : "navTab",
						rel : "",
						asc : "asc",
						desc : "desc"
					}, options);
					return this
							.each(function() {
								var $this = $(this)
										.css({
											cursor : "pointer"
										})
										.click(
												function() {
													var orderField = $this
															.attr("orderField");
													var orderDirection = $this
															.hasClass(op.asc) ? op.desc
															: op.asc;
													pageBreak({
														data : {
															orderField : orderField,
															orderDirection : orderDirection
														}
													});
												});

							});
				},
				pagerForm : function(options) {
					var op = $.extend({
						pagerForm$ : "#pagerForm",
						parentBox : document
					}, options);
					var frag = '<input type="hidden" name="#name#" value="#value#" />';
					return this
							.each(function() {
								var $searchForm = $(this), $pagerForm = $(
										op.pagerForm$, op.parentBox);
								var actionUrl = $pagerForm.attr("action")
										.replaceAll("#rel#",
												$searchForm.attr("action"));
								$pagerForm.attr("action", actionUrl);
								$searchForm
										.find(":input")
										.each(
												function() {
													var $input = $(this), name = $input
															.attr("name");
													if (name
															&& (!$input
																	.is(":checkbox,:radio") || $input
																	.is(":checked"))) {
														if ($pagerForm
																.find(":input[name='"
																		+ name
																		+ "']").length == 0) {
															var inputFrag = frag
																	.replaceAll(
																			"#name#",
																			name)
																	.replaceAll(
																			"#value#",
																			$input
																					.val());
															$pagerForm
																	.append(inputFrag);
														}
													}
												});
							});
				}
			});

	var Pagination = function(opts) {
		this.opts = $.extend({
			targetType : "navTab", // navTab, dialog
			rel : "", // 用于局部刷新div id号
			totalCount : 0,
			numPerPage : 10,
			pageNumShown : 10,
			currentPage : 1,
			callback : function() {
				return false;
			}
		}, opts);
	}

	$.extend(Pagination.prototype, {
		targetType : function() {
			return this.opts.targetType
		},
		rel : function() {
			return this.opts.rel
		},
		numPages : function() {
			return Math.ceil(this.opts.totalCount / this.opts.numPerPage);
		},
		getInterval : function() {
			var ne_half = Math.ceil(this.opts.pageNumShown / 2);
			var np = this.numPages();
			var upper_limit = np - this.opts.pageNumShown;
			var start = this.getCurrentPage() > ne_half ? Math.max(Math.min(
					this.getCurrentPage() - ne_half, upper_limit), 0) : 0;
			var end = this.getCurrentPage() > ne_half ? Math.min(this
					.getCurrentPage()
					+ ne_half, np) : Math.min(this.opts.pageNumShown, np);
			return {
				start : start + 1,
				end : end + 1
			};
		},
		getCurrentPage : function() {
			var currentPage = parseInt(this.opts.currentPage);
			if (isNaN(currentPage))
				return 1;
			return currentPage;
		},
		hasPrev : function() {
			return this.getCurrentPage() > 1;
		},
		hasNext : function() {
			return this.getCurrentPage() < this.numPages();
		}
	});
})(jQuery);
