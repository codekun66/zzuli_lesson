// $(function () {
//     //页面初始化的时候，获取滚动条的高度（上次高度）
//     var start_height = $(document).scrollTop();
//     //获取导航栏的高度(包含 padding 和 border)
//     var navigation_height = $('.navbar').outerHeight();
//     $(window).scroll(function () {
//         //触发滚动事件后，滚动条的高度（本次高度）
//         var end_height = $(document).scrollTop();
//         //触发后的高度 与 元素的高度对比
//         if (end_height > navigation_height) {
//             $('.navbar').addClass('hide');
//         } else {
//             $('.navbar').removeClass('hide');
//         }
//         //触发后的高度 与 上次触发后的高度
//         if (end_height < start_height) {
//             $('.navbar').removeClass('hide');
//         }
//         //再次获取滚动条的高度，用于下次触发事件后的对比
//         start_height = $(document).scrollTop();
//     });
// });

$(".channel-body").focus(function(){
	$(this).css({
		"margin-left":0+"px"
	})
})