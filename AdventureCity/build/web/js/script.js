function validar()
{
    if(document.formSearch.product.value.length === 0)
    {
        document.getElementById("error").innerHTML = "Introduzca un criterio de búsqueda";
        document.formSearch.product.select;
        return false;
    }      
}

function signup(){
    if (!(document.getElementById("username").value !== '' && /^([a-zA-Z0-9_]+)$/.test(document.getElementById('username').value))) {
        document.getElementById("pUser").innerHTML = "Enter a validate Username";
        return false;
    }else{
        document.getElementById("pUser").innerHTML = "";
    }
    if (!(document.getElementById("email").value !== '' && /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(document.getElementById("email").value))) {
        document.getElementById("pEmail").innerHTML = "Enter a validate Email";
        return false;
    }else{
        document.getElementById("pEmail").innerHTML = "";
    }
    
    if (document.getElementById("password").value === '') {
        document.getElementById("pPassword").innerHTML = "Password required";
        return false;
    }
    else {
        document.getElementById("pPassword").innerHTML = "";
    }
    
    if (document.getElementById("password").value.length <= 2) {
        document.getElementById("pPassword").innerHTML = "The password to need have more than 2 caracters";
        return false;
    }
    else {
        document.getElementById("pPassword").innerHTML = "";
    }
    if (document.getElementById("password").value !== document.getElementById("pwd-repeat").value)
    	{
            document.getElementById("pRepeat").innerHTML = "You didn't enter the same password";
            return false;
        }else{
               document.getElementById("pRepeat").innerHTML = "";
        }
}

function username(){
    if (!(document.getElementById("usernames").value !== '' && /^([a-zA-Z0-9_]+)$/.test(document.getElementById('usernames').value))) {

        return false;
    }else{
        return true;
    }
}

function email(){
    if (!(document.getElementById("emailS").value !== '' && /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(document.getElementById("emailS").value))) {

        return false;
    }else{
        return true;
    }  
}

function password(){
    
    if (document.getElementById("passwordS").value === '') {
        return false;
    }
    else {
       return true;
    }
    
    if (document.getElementById("passwordS").value.length <= 2) {
      
        return false;
    }
    else {
        return true;
    }
    if (document.getElementById("passwordS").value !== document.getElementById("repeatS").value)
    	{
            
            return false;
        }else{
               return true;
        }
}


/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function myFunctionUser() {
    document.getElementById("myDropdownUser").classList.toggle("show");
}

function myFunctionAdmin() {
    document.getElementById("myDropdownAdmin").classList.toggle("show");
}


// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
        }
    }
};

function posta(){
    //Obtendo o texto digitado pelo usuário:
    var texto = document.getElementById("counter").value;
    //Armazenando a referência da Div dentro de uma variável:
    var div = document.getElementById("counter"); 
    //Inserindo o texto dentro da Div:
    div.innerHTML = texto; 
    //Limpando a caixa de texto:
    document.getElementById("counter").value = "1"; 
} 

function indisponible(){
    window.alert("This features is not available");
}

function confirm_cart()
{
    if (!(document.getElementById('card_number').value != '' && /^(\d{4}[- ]){3}\d{4}|\d{16}$/.test(document.getElementById('card_number').value))) {
        window.alert("Insert valide card number XXXX-XXXX-XXXX-XXXX or 1234 1234 1234 1234");
        return false;
    }
    if (!(document.getElementById('card_name').value != '')) {
        window.alert("Please insert a Name for the card");
        return false;
    }
    if (!(document.getElementById('cryptogramT').value != '' && /^[0-9]*$/.test(document.getElementById('cryptogramT').value))) {
        window.alert("Please insert only number in CryptoGram");
        return false;
    }
    if (!(document.getElementById('addressT').value != '')) {
        window.alert("Please write an address");
        return false;
    }
    
    if (!(document.getElementById('countryT').value != '')) {
        window.alert("Please write a country");
        return false;
    }
    if (!(document.getElementById('cityT').value != '')) {
        window.alert("Please write a city");
        return false;
    }
    if (!(document.getElementById('code').value != '' && /^[0-9]*$/.test(document.getElementById('code').value))) {
        window.alert("Please insert only number in Code");
        return false;
    }
}

function confirm_create(){
    if (!(document.getElementById('titleCreate').value != '')) {
        window.alert("Please write a Title");
        return false;
    }
    
    if (!(document.getElementById('cityCreate').value != '')) {
        window.alert("Please write the City");
        return false;
    }
    
    if (!(document.getElementById('descriptionCreate').value != '')) {
        window.alert("Please write the City");
        return false;
    }
    if (!(document.getElementById('priceCreate').value != '' && /^[0-9]*$/.test(document.getElementById('priceCreate').value))) {
        window.alert("Please insert only number for the price");
        return false;
    }
    
    
    
}




