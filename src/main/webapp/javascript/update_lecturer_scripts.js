window.onload = disableAllFormElements;

function lecturerType() {
    var rate_value;
    if (document.getElementById('lecturer_type_prof').checked) {
        rate_value = document.getElementById('lecturer_type_prof').value;
        document.getElementById("lecturer_position").disabled = false;
        document.getElementById("lecturer_res_papers").disabled = false;
        document.getElementById("lecturer_diploma").disabled = true;

    }
    if (document.getElementById('lecturer_type_ass').checked) {
        rate_value = document.getElementById('lecturer_type_ass').value;
        document.getElementById("lecturer_position").disabled = true;
        document.getElementById("lecturer_res_papers").disabled = true;
        document.getElementById("lecturer_diploma").disabled = false;
    }
}

function goBack() {
    window.history.back();
}


function disableAllFormElements() {
    var form = document.getElementById("lecturer_update_form");
    var elements = form.elements;
    for (var i = 0; i < elements.length; i++) {
        if (elements[i].id === 'lecturer_id' || elements[i].id === 'lecturer_cancel' || elements[i].id === 'lecturer_enable') {
            continue;
        }
        elements[i].disabled = true;
    }
}

function enableAllFormElements() {
    var form = document.getElementById("lecturer_update_form");
    var elements = form.elements;

    for (var i = 0; i < elements.length; i++) {
        if (elements[i].id === 'lecturer_id') {
            continue;
        }
        elements[i].disabled = false;
    }
    lecturerType();
    document.getElementById('lecturer_enable').disabled = true;

}

function filterFunction(inputField, selectField) {
  var input, filter, ul, li, a, i;
  filter = inputField.value.toUpperCase();
  a = selectField.getElementsByTagName("option");
  for (i = 0; i < a.length; i++) {
    if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
      a[i].style.display = "";
    } else {
      a[i].style.display = "none";
    }
  }
}
