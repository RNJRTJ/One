/*function scrollDown() {
  var conteudoNotification = document.getElementById("conteudoNotification");
  conteudoNotification.scrollTop = 200;
}*/

console.log("Hello roll!");

function scrollDown(direction) {
  var conteudoNotification = document.getElementById("conteudoNotification");
  var qddScroll = 200;
  
  if (direction === "up") {
    conteudoNotification.scrollTop -= qddScroll;
  } else {
    conteudoNotification.scrollTop += qddScroll;
  }
}