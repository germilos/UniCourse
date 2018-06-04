function lecturerNameValidate() {
    var text, x;

    x = document.getElementById("lecturer_name").value;
    if (!(/^(\s*|[A-Z][a-z0-9]+)$/.test(x)) || x.length > 50) {
        document.getElementById("name_error").innerHTML = "Input not valid";
        return false;
    } else {
        document.getElementById("name_error").innerHTML = "";
        return true;
    }
}

function surnameValidate() {
    var text, x;

    x = document.getElementById("lecturer_surname").value;
    if (!(/^(\s*|[A-Z][a-z0-9]+)$/.test(x)) || x.length > 50) {
        document.getElementById("surname_error").innerHTML = "Input not valid";
        return false;
    } else {
        document.getElementById("surname_error").innerHTML = "";
        return true;
    }
}

function fieldValidate() {
    var text, x;

    x = document.getElementById("lecturer_field").value;
    if (!(/^(\s*|[A-Z][a-z0-9]+)$/.test(x)) || x.length > 50) {
        document.getElementById("field_error").innerHTML = "Input not valid";
        return false;
    } else {
        document.getElementById("field_error").innerHTML = "";
        return true;
    }
}

function resPapperValidate() {
    var x;

    // Get the value of the input field with id="numb"
    x = document.getElementById("lecturer_res_papers").value;

    if (!isNaN(x) || x > 1 || x === "") {
        document.getElementById("res_papper_error").innerHTML = "";
        return true;
    } else {
       document.getElementById("res_papper_error").innerHTML = "Input not valid";
        return false; 
    }
}


function allFieldsFilledValidate() {
    var inputs = document.querySelectorAll("input[type=text]");
    
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].id === 'lecturer_res_papers') 
            if (document.getElementById('lecturer_type_prof').checked && inputs[i].value === '') {
                return false;
            } else {
               continue;
            }
        if (inputs[i].value === '') {
            return false;
        }
    }
    return true;
}

function allErrorsValidate() {
    var errors = document.getElementsByClassName('error_label');
    var counter = 0;

    for (var i = 0; i < errors.length; i++) {
        if (errors[i].innerHTML === "Input not valid") {
            return false;
        }
    }
    
    return true;
}

function enableSaving() {
    if (allErrorsValidate() && allFieldsFilledValidate() && document.getElementById('lecturer_enable').disabled == true)
        document.getElementById('lecturer_add').disabled = false;
    else
        document.getElementById('lecturer_add').disabled = true;
}

window.onload = assistantsValidate;