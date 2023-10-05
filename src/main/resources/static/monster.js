$(document).ready(function() {
    // Function to fetch and display the list of monsters
    function fetchMonsters() {
        $.get("/api/v1/monster", function(monsters) {
            $("#monsterList").empty();
            monsters = monsters.sort((a,b) => {
            if (a.id < b.id) {
                return -1;
              }
            })
            monsters.forEach(function(monster) {
                $("#monsterList").append(
                    "<tr>" +
                    "<td>" + monster.id + "</td>" +
                    "<td>" + monster.name + "</td>" +
                    "<td>" + monster.element + "</td>" +
                    "<td>" + monster.level + "</td>" +
                    "<td>" + monster.health + "</td>" +
                    "<td>" + monster.attack + "</td>" +
                    "<td>" + monster.defense + "</td>" +
                    "</tr>"
                );
            });
        });
    }

    // Initial fetch of monsters
    fetchMonsters();

    // Add Monster Form Submission
    $("#addMonsterForm").submit(function(event) {
        event.preventDefault();
        var formData = {
//            id: 10,
            name: $("#name").val(),
            element: $("#element").val(),
            level: $("#level").val(),
            health: $("#health").val(),
            attack: $("#attack").val(),
            defense: $("#defense").val()
        };

        $.ajax({
            url: "/api/v1/monster/",
            type: "POST",
            data: JSON.stringify(formData),
            contentType: "application/json",
            success: function() {
                fetchMonsters();
                $("#addMonsterForm")[0].reset();
            }
        });
    });

    // Update Monster Button Click
    $(document).on("click", ".updateButton", function() {
        var monsterId = $(this).data("id");

        $.get("/api/v1/monster/" + monsterId, function(monster) {
            $("#updateId").val(monster.id);
            $("#updateName").val(monster.name);
            $("#updateElement").val(monster.element);
            $("#updateLevel").val(monster.level);
            $("#updateHealth").val(monster.health);
            $("#updateAttack").val(monster.attack);
            $("#updateDefense").val(monster.defense);
        });
    });

    // Update Monster Form Submission
    $("#updateMonsterForm").submit(function(event) {
        event.preventDefault();
        var monsterId = $("#updateId").val();
        var formData = {
            name: $("#updateName").val(),
            element: $("#updateElement").val(),
            level: $("#updateLevel").val(),
            health: $("#updateHealth").val(),
            attack: $("#updateAttack").val(),
            defense: $("#updateDefense").val()
        };

        $.ajax({
            url: "/api/v1/monster/" + monsterId,
            type: "PUT",
            data: JSON.stringify(formData),
            contentType: "application/json",
            success: function() {
                fetchMonsters;
                $("#updateMonsterForm")[0].reset();
                location.reload();
            }
        });
    });

    // Delete Monster Form Submission
    $("#deleteMonsterForm").submit(function(event) {
        event.preventDefault();
        var monsterId = $("#deleteId").val();

        $.ajax({
            url: "/api/v1/monster/" + monsterId,
            type: "DELETE",
            success: function() {
                fetchMonsters();
                $("#deleteMonsterForm")[0].reset();
            }
        });
    });
});
