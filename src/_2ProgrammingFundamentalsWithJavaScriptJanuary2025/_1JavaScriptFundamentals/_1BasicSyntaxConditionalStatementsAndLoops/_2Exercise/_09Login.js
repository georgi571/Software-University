function login(input) {
    let index = 0;
    const userName = input[index++];
    let password = "";
    for (let i = userName.length - 1; i >= 0; i--) {
        const currentSymbol = userName.charAt(i);
        password += currentSymbol;
    }
    let inputPassword = input[index++];
    let counter = 0;
    while (inputPassword !== password) {
        counter++;
        if (counter === 4) {
            console.log(`User ${userName} blocked!`);
            break;
        } else {
            console.log('Incorrect password. Try again.');
            inputPassword = input[index++];
        }
    }
    if (inputPassword === password) {
        console.log(`User ${userName} logged in.`);
    }
}