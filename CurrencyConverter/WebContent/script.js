document.addEventListener("DOMContentLoaded", function() {
    const currencies = ["USD", "EUR", "GBP", "INR", "JPY", "CAD", "AUD"];
    const fromCurrency = document.getElementById("fromCurrency");
    const toCurrency = document.getElementById("toCurrency");

    // Populate currency dropdowns
    currencies.forEach(currency => {
        const option1 = document.createElement("option");
        option1.value = currency;
        option1.text = currency;
        fromCurrency.add(option1);

        const option2 = document.createElement("option");
        option2.value = currency;
        option2.text = currency;
        toCurrency.add(option2);
    });

    document.getElementById("convertBtn").addEventListener("click", function() {
        const amount = document.getElementById("amount").value;
        const from = fromCurrency.value;
        const to = toCurrency.value;

        if (amount === "") {
            alert("Please enter an amount.");
            return;
        }

        fetch(`convert?amount=${amount}&from=${from}&to=${to}`)
            .then(response => response.json())
            .then(data => {
                const resultDiv = document.getElementById("result");
                resultDiv.innerHTML = `
                    <p>${amount} ${from} = ${data.convertedAmount.toFixed(2)} ${to}</p>
                    <p>Exchange Rate: 1 ${from} = ${data.exchangeRate} ${to}</p>
                `;
            })
            .catch(error => console.error('Error:', error));
    });
});
