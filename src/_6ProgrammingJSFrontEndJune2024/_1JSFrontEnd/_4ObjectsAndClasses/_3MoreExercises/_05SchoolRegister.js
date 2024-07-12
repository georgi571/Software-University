function schoolRegister(input) {
    const schoolRegister = [];
    for (let inputElement of input) {
        const studentInformation = inputElement.split(', ');
        const studentName = studentInformation[0].split(': ')[1];
        const studentGrade = Number(studentInformation[1].split(': ')[1]) + 1;
        const studentScore = Number(studentInformation[2].split(': ')[1]);
        if (studentScore >= 3) {
            const student = {
                studentGrade: studentGrade,
                studentName: studentName,
                studentScore: studentScore,
            }
            schoolRegister.push(student);
        }
    }
    schoolRegister.sort((a,b) => a.studentGrade - b.studentGrade);
    for (let i = 1; i <= 12; i++) {
        const currentGrade = schoolRegister.filter(student => student.studentGrade === i);
        const currentNames = [];
        let totalScore = 0;
        for (let currentGradeElement of currentGrade) {
            currentNames.push(currentGradeElement.studentName);
            totalScore += currentGradeElement.studentScore;
        }
        const averageScore = totalScore / currentNames.length;
        if (currentGrade.length > 0) {
            console.log(`${i} Grade`);
            console.log(`List of students: ${currentNames.join(', ')}`);
            console.log(`Average annual score from last year: ${averageScore.toFixed(2)}`);
            console.log()

        }
    }
}