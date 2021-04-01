$('#password').focusin(function(){
   $('form').addClass('up')
       setTimeout(function(){
           $('form').removeClass('up');
         },2000 );
});
$('#password').focusout(function(){
  $('form').removeClass('up')
});

// Panda Eye move
$(document).on( "mousemove", function( event ) {
  var dw = $(document).width() / 15;
  var dh = $(document).height() / 15;
  var x = event.pageX/ dw;
  var y = event.pageY/ dh;
  $('.eye-ball').css({
    width : x,
    height : y
  });
});

// validation


$('.btn').click(function(){
var x=document.getElementById("username").value;
var y=document.getElementById("password").value;
if(x.length==0||y.length==0)
{
document.getElementById("che").innerHTML="Invalid Input";
}
else
{
document.getElementById("che").innerHTML="Login Successful";
}

  $('form').addClass('wrong-entry');
    setTimeout(function(){
       $('form').removeClass('wrong-entry');
     },3000 );
});
$(document).ready(function() {
        // Transition effect for navbar 
        $(window).scroll(function() {
          // checks if window is scrolled more than 500px, adds/removes solid class
          if($(this).scrollTop() > 500) { 
              $('.navbar').addClass('solid');
          } else {
              $('.navbar').removeClass('solid');
          }
        });
});