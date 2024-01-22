document.addEventListener('DOMContentLoaded', function () {
    var emailInput = document.querySelector('#email');
    var submitButton = document.querySelector('#submitBtn');

    emailInput.addEventListener('input', function () {
        var email = emailInput.value;
        var isValid = validateEmail(email);

        if (!isValid) {
            alert('Invalid email address. Please enter a valid email.');
            submitButton.disabled = true;
        } else {
            submitButton.disabled = false;
        }
    });

    function validateEmail(email) {
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
});
