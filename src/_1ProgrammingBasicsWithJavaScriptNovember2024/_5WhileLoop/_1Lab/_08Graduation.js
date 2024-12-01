function graduation(input) {
    const studentName = input[0];
    let totalSumOfGrade = 0;
    let grade = 1;
    let fail = 0;

    let counter = 1;
    while (grade <= 12) {
        const currentGrade = Number(input[counter++]);

        if (currentGrade < 4) {
            fail++;
            if (fail === 2) {
                break;
            }
            continue;
        }

        totalSumOfGrade += currentGrade;
        grade++;
    }

    const averageGrade = totalSumOfGrade / 12;

    if (grade > 12) {
        console.log(`${studentName} graduated. Average grade: ${averageGrade.toFixed(2)}`);
    } else {
        console.log(`${studentName} has been excluded at ${grade} grade`);
    }

}