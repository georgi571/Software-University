function examPreparation(input) {
    const countPoorGrades = Number(input[0]);
    let command = input[1];

    let countCurrentPoorGrades = 0;
    let numberOfProblems = 0;
    let sumOfGrades = 0;
    let lastProblem;

    let counter = 2;
    while (command !== "Enough") {
        lastProblem = command;
        const grade = Number(input[counter++]);

        if (grade <= 4) {
            countCurrentPoorGrades++;
            if (countCurrentPoorGrades === countPoorGrades) {
                break;
            }
        }

        numberOfProblems++;
        sumOfGrades += grade;

        command = input[counter++];
    }

    if (countCurrentPoorGrades === countPoorGrades) {
        console.log(`You need a break, ${countCurrentPoorGrades} poor grades.`);
    } else {
        const average = sumOfGrades / numberOfProblems;
        console.log(`Average score: ${average.toFixed(2)}`);
        console.log(`Number of problems: ${numberOfProblems}`);
        console.log(`Last problem: ${lastProblem}`);
    }
}