function password(input) {
    const username = input[0];
    const password = input[1];
    let check = input[2];
    let counter = 3;
    while (check !== password) {
        check = input[counter++];
    }
    console.log(`Welcome ${username}!`);
}