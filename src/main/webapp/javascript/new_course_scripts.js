function goBack() {
    window.history.back();
}
function enableInputs() {
    var elem = document.getElementById("course_info").elements;
    document.getElementById("course_update").disabled = false;

    for (var i = 0; i < elem.length; i++) {
        if (elem[i].type === "text" || elem[i].type === "textarea") {
            if (elem[i].id === "course_id") {
                continue;
            }
            elem[i].disabled = false;
        }
    }
    document.getElementById("course_edit").disabled = true;
    document.getElementById("course_status").disabled = false;
    document.getElementById("course_st_program").disabled = false;
    document.getElementById("course_dept").disabled = false;

}

function addField(argument) {
    var myTable = document.getElementById("myTable");
    var currentIndex = myTable.rows.length;

    if (document.getElementById("myTable").rows[currentIndex - 1].cells[1].children[0].value === "") {
        alert("You must enter the course unit name first!");

    } else {
        var currentRow = myTable.insertRow(-1);
        var cuNumber = document.createElement("input");
        cuNumber.setAttribute("type", "text")
        cuNumber.setAttribute("name", "cuNumber");
        cuNumber.setAttribute("value", currentIndex);
        cuNumber.setAttribute("readonly", true);

        var cuName = document.createElement("input");
        cuName.setAttribute("type", "text");
        cuName.setAttribute("name", "cuName");
        
        var cuDescription = document.createElement("textarea");
        cuDescription.setAttribute("name", "cuDescription");
        cuDescription.setAttribute("rows", "3");

        var currentCell = currentRow.insertCell(-1);
        currentCell.appendChild(cuNumber);

        currentCell = currentRow.insertCell(-1);
        currentCell.appendChild(cuName);
        
        currentCell = currentRow.insertCell(-1);
        currentCell.appendChild(cuDescription);
    }
}

function deleteRow() {

    var table = document.getElementById("myTable");
    if (table.rows.length > 2) {
        if (confirm('Are you sure you want to delete this course unit?')) {
            var rowCount = table.rows.length;
            table.deleteRow(rowCount - 1);
        }
    }
}

$(function () {
    function moveItems(origin, dest) {
        $(origin).find(':selected').appendTo(dest);
        $('#professors_selected option').prop('selected', true);
        $('#assistants_selected option').prop('selected', true);
    }

    function moveAllItems(origin, dest) {
        $(origin).children().appendTo(dest);
        $('#professors_selected option').prop('selected', true);
        $('#assistants_selected option').prop('selected', true);
    }

    $('#left_professors').click(function () {
        moveItems('#professors_selected', '#professors_unselected');
    });

    $('#right_professors').on('click', function () {
        moveItems('#professors_unselected', '#professors_selected');
    });

    $('#leftall_professors').on('click', function () {
        moveAllItems('#professors_selected', '#professors_unselected');
    });

    $('#rightall_professors').on('click', function () {
        moveAllItems('#professors_unselected', '#professors_selected');
    });

    $('#left_assistants').click(function () {
        moveItems('#assistants_selected', '#assistants_unselected');
    });

    $('#right_assistants').on('click', function () {
        moveItems('#assistants_unselected', '#assistants_selected');
    });

    $('#leftall_assistants').on('click', function () {
        moveAllItems('#assistants_selected', '#assistants_unselected');
    });

    $('#rightall_assistants').on('click', function () {
        moveAllItems('#assistants_unselected', '#assistants_selected');
    });
    
});