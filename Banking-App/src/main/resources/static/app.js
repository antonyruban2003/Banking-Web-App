// Handle Account Creation
document.getElementById('create-account-form')?.addEventListener('submit', function(event) {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const initialDeposit = document.getElementById('initial-deposit').value;

    fetch('/api/accounts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, balance: initialDeposit })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Account created:', data); // Log the created account data
        if (data && data.id !== undefined) {
            alert('Account created successfully! Account ID: ' + data.id);
        } else {
            alert('Account creation failed');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error creating account');
    });
});

// Handle Fetch Account Details
document.getElementById('account-details-form')?.addEventListener('submit', function(event) {
    event.preventDefault();
    const accountId = document.getElementById('account-number-details').value;

    fetch(`/api/accounts/${accountId}`)
    .then(response => response.json())
    .then(data => {
        console.log('Account details:', data); // Log the fetched account details
        if (data && data.id !== undefined) {
            document.getElementById('account-details').innerText = 
                `name: ${data.name}\nBalance: ${data.balance}`;
        } else {
            document.getElementById('account-details').innerText = 'Account not found';
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error fetching account details');
    });
});


// Handle Transaction (Deposit/Withdraw)
document.getElementById('transaction-form')?.addEventListener('submit', function(event) {
    event.preventDefault();
    const accountId = document.getElementById('account-number-transaction').value;
    const amount = document.getElementById('amount').value;
    const transactionType = document.getElementById('transaction-type').value;

    fetch(`/api/accounts/${accountId}/${transactionType}?amount=${amount}`, {
        method: 'POST'
    })
    .then(response => response.json())
    .then(data => {
        console.log('Transaction response:', data); // Log the transaction response
        if (data && data.balance !== undefined) {
            alert('Transaction successful! New Balance: ' + data.balance);
        } else {
            alert('Transaction failed');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error processing transaction');
    });
});
