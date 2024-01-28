document.addEventListener('DOMContentLoaded', function () {
  var urlParams = new URLSearchParams(window.location.search);
  var showAlert = urlParams.get('showAlert');

  if (showAlert === 'true') {
    var myToast = new bootstrap.Toast(document.getElementById('alertToast'));
    myToast.show();
  }
});