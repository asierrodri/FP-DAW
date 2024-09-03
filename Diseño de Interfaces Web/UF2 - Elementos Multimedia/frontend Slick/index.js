//2.1
function validaForm(){
    if($("#text").val() == ""){
        alert("Tienes que introducir un texto.");
        $("#text").focus();
        return false;
    }
}

$(document).ready(
    function() {
        //1.1
        $("#setDoubleSize").dblclick(
            function(){
                let anchura=$("#divTarget").width();
                anchura=anchura*2;
                $('#divTarget').width(anchura);
            }
        );

        //1.2
        $("#setBlueColor").hover(
            function(){
                $(this).css("background-color","blue");
            },
            function(){
                $(this).css("background-color","white");
            }
        );

        //1.3
        let isAnimating = false;
          
/*         $("#mov").click(function() {
            if (isAnimating) {
            $("#divTarget").stop();
            $('#divTarget').animate({top: '0px'}, {duration:0});
            isAnimating = false;
            }
            else {
                $("#divTarget").animate({top: '500px'}, {duration:3000});
                isAnimating = true;
            }
        }); */
        $("#mov").click(function() {
            if (!isAnimating) {
                isAnimating = true;      
                $("#divTarget").animate({top: '500px'}, {duration:3000});    
            }
            else {
                $("#divTarget").stop();
                isAnimating = false;
                $("#divTarget").css("top","0");
            }
        });

        //2.1
        let i = 1;
        $("#addDiv").click(function() {
            if(validaForm() != false){
                let texto=$("#text").val();
                let nuevoDiv=$('<div>'+texto+i+'</div>');
                $('#domNodes').append(nuevoDiv);
                i++;
                nuevoDiv.click(
                    function(){
                        $(this).remove();
                     }
                );    
            }
        });

        //3
        $("#slider").slick({
            slidesToShow: 3,
            slidesToScroll: 1,
            nextArrow:"<button> NEXT </button>",
            prevArrow:"<button> PREV </button>",
            autoplay: true,
            autoplaySpeed: 3000,
            responsive: [
            {
                breakpoint: 600, settings: {
                    slidesToShow: 1,
                    arrows: false,
                    dots: true,
                    autoplay: false
                }
            }
            ]
        });
    }
);