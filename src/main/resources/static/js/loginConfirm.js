document.addEventListener("DOMContentLoaded", function() {
    var parametroLogin = new URLSearchParams(window.location.search).get('login');
    var loginPane = document.getElementById('loginPane');
    var loginConfirmed = document.getElementById('loginConfirmed');

    if (parametroLogin === 'false') {
        loginPane.style.display = 'block';
        loginConfirmed.style.display = 'none';
    } else {
        loginPane.style.display = 'none';
        loginConfirmed.style.display = 'block';
    }
});
