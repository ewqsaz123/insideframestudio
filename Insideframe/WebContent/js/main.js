//스크립트 소스는 여기에

$(function(){

    // Gnb Start
    var menuItem = $("#gnb li a");
    
    menuItem.click(function(){
        $(this).addClass('act')
            .parent().siblings().find('a').removeClass('act');
        
        var el = $(this).attr('href');
        var elWrapped = $(el);
                    
        scrollToDiv(elWrapped,50);
        return false;
    });
                
    function scrollToDiv(element,navheight){
        var offset = element.offset();
        var offsetTop = offset.top;
        var totalScroll = offsetTop-navheight;
                
        $('body,html').animate({
            scrollTop: totalScroll
        }, 500);
    }


	// progress-bar Start
	$(".progress-bar").loading();

	// lightBox Start
	$('#imgBox a').lightBox({
    overlayBgColor: '#000',
    overlayOpacity: 0.5,
    imageLoading: '../images/lightbox-ico-loading.gif',
    imageBtnClose: '../images/lightbox-btn-close.gif',
    imageBtnPrev: '../images/lightbox-btn-prev.gif',
    imageBtnNext: '../images/lightbox-btn-next.gif'
   });

   // slider Start
   $('#slider').rbtSlider({
        height: '100vh', 
        'dots': true,
        'arrows': true,
        'auto': 3
    });

    //stellar Start
    $.stellar({
      horizontalOffset: 40,
      verticalOffset: 150
    });

    $('#header').mouseleave(function(){
        $('#gnb').removeClass('in');
    });


});