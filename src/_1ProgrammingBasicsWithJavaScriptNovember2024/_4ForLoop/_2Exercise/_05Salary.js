function salary(input) {
    const FINE_FOR_TAB_FACEBOOK = 150;
    const FINE_FOR_TAB_INSTAGRAM = 100;
    const FINE_FOR_TAB_REDDIT= 50;

    const n = input[0];
    let salary = input[1];

    for (let i = 2; i <= n + 1; i++) {
        const tabName = input[i];

        if (tabName === "Facebook") {
            salary -= FINE_FOR_TAB_FACEBOOK;
        } else if (tabName === "Instagram") {
            salary -= FINE_FOR_TAB_INSTAGRAM;
        } else if (tabName === "Reddit") {
            salary -= FINE_FOR_TAB_REDDIT;
        }

        if (salary <= 0) {
            console.log(`You have lost your salary.`);
            return;
        }
    }

    console.log(`${salary}`);
}
