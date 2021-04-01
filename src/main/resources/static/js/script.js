$('#image').focusin(function(){
  $('form').addClass('up')
});
$('#Description').focusin(function(){
  $('form').addClass('up')
});
$('#image').focusout(function(){
  $('form').removeClass('up')
});
$('#Description').focusout(function(){
  $('form').removeClass('up')
});

// Panda Eye move
$( document ).on( "mousemove", function( event ) {
  var x = event.pageX/50;
  var y = event.pageY/25;
  $('.eye-ball').css({
    width : x,
    height : y
  });
});

// validation


$('.btn').click(function(){
  $('form').addClass('wrong-entry');
    setTimeout(function(){ 
       $('form').removeClass('wrong-entry');
     },3000 );
});