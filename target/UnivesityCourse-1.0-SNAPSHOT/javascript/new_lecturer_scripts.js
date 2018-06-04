window.onload = lecturerType;

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

