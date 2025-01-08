function exam(input) {
    const n = Number(input[0]);
    let countTo3 = 0;
    let countTo4 = 0;
    let countTo5 = 0;
    let countTo6 = 0;
    let totalGrade = 0;

    let index = 1;
    for (let i = 0; i < n; i++) {
        const grade = Number(input[index++]);
        if (grade >= 5.00) {
            countTo6++;
        } else if (grade >= 4.00) {
            countTo5++;
        }  else if (grade >= 3.00) {
            countTo4++;
        } else {
            countTo3++;
        }
        totalGrade += grade;
    }
    const gradeTo6 = (countTo6 / n) * 100.00;
    const gradeTo5 = (countTo5 / n) * 100.00;
    const gradeTo4 = (countTo4 / n) * 100.00;
    const gradeTo3 = (countTo3 / n) * 100.00;
    const average = totalGrade / n;
    console.log(`Top students: ${gradeTo6.toFixed(2)}%`);
    console.log(`Between 4.00 and 4.99: ${gradeTo5.toFixed(2)}%`);
    console.log(`Between 3.00 and 3.99: ${gradeTo4.toFixed(2)}%`);
    console.log(`Fail: ${gradeTo3.toFixed(2)}%`);
    console.log(`Average: ${average.toFixed(2)}`);
}

exam((["10",
    "3.00",
    "2.99",
    "5.68",
    "3.01",
    "4",
    "4",
    "6.00",
    "4.50",
    "2.44",
    "5"])
)

exam((["6",
    "2",
    "3",
    "4",
    "5",
    "6",
    "2.2"])
)