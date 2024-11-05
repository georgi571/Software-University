function weatherForecastPart2(temperature) {
    if (temperature >= 26 && temperature <= 35) {
        console.log("Hot");
    } else if (temperature > 20 && temperature < 26) {
        console.log("Warm");
    } else if (temperature >= 15 && temperature <= 20) {
        console.log("Mild");
    } else if (temperature >= 12 && temperature < 15) {
        console.log("Cool");
    } else if (temperature >= 5 && temperature < 12) {
        console.log("Cold");
    } else {
        console.log("unknown");
    }
}