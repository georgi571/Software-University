function solve(number, array) {
    let newArray = [];
    for (let i = 0; i < number; i++) {
        newArray.push(array[i]);
    }
    let output = '';
    for (let i = 0; i < number; i++) {
        output += newArray.pop() + ' ';
    }
    console.log(output);
}