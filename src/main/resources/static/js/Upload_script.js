$('#image').focusin(function(){
  $('form').addClass('up')
     setTimeout(function(){
         $('form').removeClass('up');
       },3000 );
});
$('#image').focusout(function(){
  $('form').removeClass('up')
});
$('#Description').focusin(function(){
  $('form').addClass('up')
     setTimeout(function(){
           $('form').removeClass('up');
         },3000 );
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
$('.btn').click(function()
{
var x=document.getElementById("title").value;
var y=document.getElementById("tags").value;
var a=document.getElementById("description").value;
if(x.length<3||y.length<3||a.length<3||a>25||x.length>25||y.length>25)
{
document.getElementById("che").innerHTML="Invalid Input";
}
else
{
document.getElementById("che").innerHTML="Uploaded Successfully";
}
    setTimeout(function(){
       $('form').removeClass('wrong-entry');
     },3000 );
});
