window.onload = function () {
    bootlint.showLintReportForCurrentDocument([], {
        hasProblems: false,
        problemFree: false
    });

    $('[data-toggle="tooltip"]').tooltip();

    function formatDate(date) {
        return (
            date.getDate() +
            "/" +
            (date.getMonth() + 1) +
            "/" +
            date.getFullYear()
        );
    }

    $(document).ready(function() {
        $('.todo-item').on('click', '.fa-check-square-o', function() {
            $(this).toggleClass('d-none');
            $(this).toggleClass('m-0 p-0');
        });
    });


    var currentDate = formatDate(new Date());

    $(".due-date-button").datepicker({
        format: "dd/mm/yyyy",
        autoclose: true,
        todayHighlight: true,
        startDate: currentDate,
        orientation: "bottom right"
    });

    $(".due-date-button").on("click", function (event) {
        $(".due-date-button")
            .datepicker("show")
            .on("changeDate", function (dateChangeEvent) {
                $(".due-date-button").datepicker("hide");
                $(".due-date-label").text(formatDate(dateChangeEvent.date));
            });
    });
};
