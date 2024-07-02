function solve(input) {
    const username = input[0];
    let password = '';
    for (let i = username.length - 1; i >= 0; i--) {
        password += username[i];
    }
    let counter = 0;
    for (let i = 1; i < input.length; i++) {
        if (input[i] === password) {
            console.log(`User ${username} logged in.`);
        } else {
            counter++;
            if (counter === 4) {
                console.log(`User ${username} blocked!`);
            } else {
                console.log(`Incorrect password. Try again.`);
            }
        }
    }
}