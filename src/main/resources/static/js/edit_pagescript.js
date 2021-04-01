$('#image').focusin(function(){
  $('form').addClass('up')
     setTimeout(function(){
         $('form').removeClass('up');
       },1000 );
});
$('#image').focusout(function(){
  $('form').removeClass('up')
});
$('#Description').focusin(function(){
  $('form').addClass('up')
     setTimeout(function(){
           $('form').removeClass('up');
         },2000 );
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
var a=document.getElementById("Description").value;
if(x.length==0||y.length==0||a.length==0)
{
document.getElementById("che").innerHTML="Invalid Input";
}
else
{
document.getElementById("che").innerHTML="Updated Successfully";
}

    setTimeout(function(){
       $('form').removeClass('wrong-entry');
     },3000 );
});
