

function validate(){
    var password = document.registration.password.value;
    if(password.length < 8){
        alert("Пароль должен содержать минимсу 8 символов")
        return false;
    }
}