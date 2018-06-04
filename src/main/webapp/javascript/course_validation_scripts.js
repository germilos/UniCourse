function espbValidate() {
    var x, text;

    // Get the value of the input field with id="numb"
    x = document.getElementById("course_espb").value;

    // If x is Not a Number or less than one or greater than 10
    if (!isNaN(x) || x > 1 || x === "") {
        document.getElementById("espb_error").innerHTML = "";
        return true;
    } else {
        document.getElementById("espb_error").innerHTML = "Input not valid";
        return false;
    }

}
function goalValidate() {
    var text, x;

    x = document.getElementById("course_goal").value;
    if (!(/^(\s*|[A-Z][a-z0-9]+)$/.test(x)) || x.length > 250) {
        document.getElementById("goal_error").innerHTML = "Input not valid";
        return false;
    } else {
        document.getElementById("goal_error").innerHTML = "";
        return true;
    }
}
function nameValidate() {
    var text, x;

    x = document.getElementById("course_name").value;
    if (!(/^(\s*|[A-Z][a-z0-9]+)$/.test(x)) || x.length > 50) {
        document.getElementById("name_error").innerHTML = "Input not valid";
        return false;
    } else {
        document.getElementById("name_error").innerHTML = "";
        return true;
    }
}

function assistantsValidate() {
    if (document.getElementById('assistants_selected').length === 0) {
        document.getElementById('assistant_error').innerHTML = "You must select at least one assistant";
        return false;
    } else {
        document.getElementById('assistant_error').innerHTML = "";
        return true;
    }
}

function professorsValidate() {
    if (document.getElementById('professors_selected').options.length === 0) {
        document.getElementById('professor_error').innerHTML = "You must select at least one professor";
        return false;
    } else {
        document.getElementById('professor_error').innerHTML = "";
        return true;
    }
}

function allFieldsFilledValidate() {
    var inputs = document.querySelectorAll("input[type=text]");

    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].value === '') {
            return false;
        }
    }
    return true;
}

function allErrorsValidate() {
    var errors = document.getElementsByClassName('error_label');

    for (var i = 0; i < errors.length; i++) {
        if (errors[i].innerHTML === "Input not valid") {
            return false;
        }
    }

    return true;
}

function enableSaving() {
    if (allErrorsValidate() && allFieldsFilledValidate() && document.getElementById('course_enable').disabled === true) {
        document.getElementById('course_add').disabled = false;
    } else {
        document.getElementById('course_add').disabled = true;
    }
}