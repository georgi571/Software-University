function schoolCamp(season, typeOfGroup, numberOfStudents, numberOfNights) {
    const PRICE_FOR_BOYS_OR_GIRLS_GROUP_AT_WINTER_BREAK = 9.60;
    const PRICE_FOR_BOYS_OR_GIRLS_GROUP_AT_SPRING_BREAK = 7.20;
    const PRICE_FOR_BOYS_OR_GIRLS_GROUP_AT_SUMMER_BREAK = 15.00;
    const PRICE_FOR_TOGETHER_GROUP_AT_WINTER_BREAK = 10.00;
    const PRICE_FOR_TOGETHER_GROUP_AT_SPRING_BREAK = 9.50;
    const PRICE_FOR_TOGETHER_GROUP_AT_SUMMER_BREAK = 20.00;

    const DISCOUNT_IF_STUDENTS_ARE_50_OR_MORE = 0.50;
    const DISCOUNT_IF_STUDENTS_ARE_20_TO_49 = 0.15;
    const DISCOUNT_IF_STUDENTS_ARE_10_TO_19 = 0.05;

    const SPORT_FOR_GIRLS_AT_WINTER_BREAK = "Gymnastics";
    const SPORT_FOR_GIRLS_AT_SPRING_BREAK = "Athletics";
    const SPORT_FOR_GIRLS_AT_SUMMER_BREAK = "Volleyball";
    const SPORT_FOR_BOYS_AT_WINTER_BREAK = "Judo";
    const SPORT_FOR_BOYS_AT_SPRING_BREAK = "Tennis";
    const SPORT_FOR_BOYS_AT_SUMMER_BREAK = "Football";
    const SPORT_FOR_TOGETHER_AT_WINTER_BREAK = "Ski";
    const SPORT_FOR_TOGETHER_AT_SPRING_BREAK = "Cycling";
    const SPORT_FOR_TOGETHER_AT_SUMMER_BREAK = "Swimming";

    let moneyForOneNightForGroup = 0.00;
    let sport;

    if (season === "Summer") {
        if (typeOfGroup === "boys") {
            moneyForOneNightForGroup = numberOfStudents * PRICE_FOR_BOYS_OR_GIRLS_GROUP_AT_SUMMER_BREAK;
            sport = SPORT_FOR_BOYS_AT_SUMMER_BREAK;
        } else if (typeOfGroup === "girls") {
            moneyForOneNightForGroup = numberOfStudents * PRICE_FOR_BOYS_OR_GIRLS_GROUP_AT_SUMMER_BREAK;
            sport = SPORT_FOR_GIRLS_AT_SUMMER_BREAK;
        } else if (typeOfGroup === "mixed") {
            moneyForOneNightForGroup = numberOfStudents * PRICE_FOR_TOGETHER_GROUP_AT_SUMMER_BREAK;
            sport = SPORT_FOR_TOGETHER_AT_SUMMER_BREAK;
        }
    } else if (season === "Winter") {
        if (typeOfGroup === "boys") {
            moneyForOneNightForGroup = numberOfStudents * PRICE_FOR_BOYS_OR_GIRLS_GROUP_AT_WINTER_BREAK;
            sport = SPORT_FOR_BOYS_AT_WINTER_BREAK;
        } else if (typeOfGroup === "girls") {
            moneyForOneNightForGroup = numberOfStudents * PRICE_FOR_BOYS_OR_GIRLS_GROUP_AT_WINTER_BREAK;
            sport = SPORT_FOR_GIRLS_AT_WINTER_BREAK;
        } else if (typeOfGroup === "mixed") {
            moneyForOneNightForGroup = numberOfStudents * PRICE_FOR_TOGETHER_GROUP_AT_WINTER_BREAK;
            sport = SPORT_FOR_TOGETHER_AT_WINTER_BREAK;
        }
    } else if (season === "Spring") {
        if (typeOfGroup === "boys") {
            moneyForOneNightForGroup = numberOfStudents * PRICE_FOR_BOYS_OR_GIRLS_GROUP_AT_SPRING_BREAK;
            sport = SPORT_FOR_BOYS_AT_SPRING_BREAK;
        } else if (typeOfGroup === "girls") {
            moneyForOneNightForGroup = numberOfStudents * PRICE_FOR_BOYS_OR_GIRLS_GROUP_AT_SPRING_BREAK;
            sport = SPORT_FOR_GIRLS_AT_SPRING_BREAK;
        } else if (typeOfGroup === "mixed") {
            moneyForOneNightForGroup = numberOfStudents * PRICE_FOR_TOGETHER_GROUP_AT_SPRING_BREAK;
            sport = SPORT_FOR_TOGETHER_AT_SPRING_BREAK;
        }
    }

    let totalMoneyForSchoolCamp = moneyForOneNightForGroup * numberOfNights;

    if (numberOfStudents >= 50) {
        totalMoneyForSchoolCamp = totalMoneyForSchoolCamp - (totalMoneyForSchoolCamp * DISCOUNT_IF_STUDENTS_ARE_50_OR_MORE);
    } else if (numberOfStudents >= 20) {
        totalMoneyForSchoolCamp = totalMoneyForSchoolCamp - (totalMoneyForSchoolCamp * DISCOUNT_IF_STUDENTS_ARE_20_TO_49);
    } else if (numberOfStudents >= 10) {
        totalMoneyForSchoolCamp = totalMoneyForSchoolCamp - (totalMoneyForSchoolCamp * DISCOUNT_IF_STUDENTS_ARE_10_TO_19);
    }

    console.log(`${sport} ${totalMoneyForSchoolCamp.toFixed(2)} lv.`);
}