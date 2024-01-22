document.addEventListener('DOMContentLoaded', function () {
    var passwordInput = document.querySelector('#password');
    var submitButton = document.querySelector('#submitBtn');

    passwordInput.addEventListener('input', function () {
        var password = passwordInput.value;
        var isValid = checkPasswordComplexity(password);

        if (!isValid) {
            alert('Password is too weak. Please follow the password requirements.');
            submitButton.disabled = true;
        } else {
            submitButton.disabled = false;
        }
    });

    function checkPasswordComplexity(password) {
        var minLength = 8;
        var containsDigit = /\d/.test(password);

        return password.length >= minLength && containsDigit;
    }
});
