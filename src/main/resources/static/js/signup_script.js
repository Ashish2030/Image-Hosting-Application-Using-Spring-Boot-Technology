$('#password').focusin(function(){
  $('form').addClass('up')
});
$('#password').focusout(function(){
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
$('.btn').click(function()
{
var x=document.getElementById("username").value;
var y=document.getElementById("fullName").value;
var z=document.getElementById("email").value;
var a=document.getElementById("number").value;
var b=document.getElementById("password").value;

if(x.length<3||y.length<3||z.length<10||b.length==0||x==null||a.length!=10)
{
document.getElementById("che").innerHTML="Invalid Input";
console.log("k");
}
else
{
document.getElementById("che").innerHTML="Account Successfully Created";
}
  $('form').addClass('wrong-entry');
    setTimeout(function(){ 
       $('form').removeClass('wrong-entry');
     },3000 );
});


