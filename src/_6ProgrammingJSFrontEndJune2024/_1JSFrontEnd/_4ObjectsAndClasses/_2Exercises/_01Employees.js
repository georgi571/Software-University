function employees(input) {
    let employees = {};
    for (let inputElement of input) {
        employees[inputElement] = inputElement.length;
    }
    for (let employeesKey in employees) {
        console.log(`Name: ${employeesKey} -- Personal Number: ${employees[employeesKey]}`)
    }
}