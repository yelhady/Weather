function validateRegisterForm() {
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    var mobileNumber = document.getElementById('mobileNumber').value;

    if (name == '' || email == '' || password == '' || confirmPassword == '' || mobileNumber == '') {
        alert("All fields are required.");
        return false;
    }

    if (password != confirmPassword) {
        alert("Password doesn't match.");
        return false;
    }

    if (!validateEmail(email)) {
        alert("Please enter valid email.");
        return false;
    }

    if (!validateNumber(mobileNumber)) {
        alert("Please enter valid number.");
        return false;
    }

    return true;
}

function validateLoginForm() {
    if (!validateEmail(document.getElementById('email').value)) {
        alert("Please enter valid email.");
        return false;
    }

    return true;
}

function validateEmail(email) {
    var regex = /\S+@\S+\.\S+/;
    return regex.test(email);
}

function validateNumber(number) {
    var regex = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]*)$/;
    return regex.test(number);
}
