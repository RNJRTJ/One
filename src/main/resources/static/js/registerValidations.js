const form = document.querySelector('#formRegisterCli');
const userName = document.querySelector('#userName');
const login = document.querySelector('#login');
const email = document.querySelector('#email');
const password = document.querySelector('#password');
const confirmPassword = document.querySelector('#confirmPassword');

form.addEventListener("submit", (event) => {
	event.preventDefault();
    //valida nome
    
    if(userName.value === " "){
        alert("O nome não pode estar vazio!!!")
        return;
    }

    //valida Login
    if(login.value === "" || !validLogin(login.value)){
        alert("Login inválido")
        return;
    }

    //valida email
    if(email.value === "" || !isEmailValid(email.value) || !validEmail(email.value)){
        alert("O email é inválido")
        return;
    }

    //valida senha
    if(password.value === "" || !validPassword(password.value) ){
        alert("Senha inválida")
        return;
    }
    

    form.submit();
    console.log("Submited")
})




function isEmailValid(email){
    const emailRegex = new RegExp(
        /^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]{2,}$/
    );

    if(emailRegex.test(email)){
        return true;
    }

    return false
}

function validEmail(email){
    if(email.length <= 85){
        return true;
    }
    return false

}
function validPassword(password){
    if(password.length <= 25){
        return true;
    }
    return false
}

function validLogin(login){
    if(login.length < 50){
        return true;
    }
    return false;
}