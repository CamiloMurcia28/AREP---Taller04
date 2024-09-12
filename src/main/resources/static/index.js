async function sendMessage() {
    const message = document.getElementById('messageInput').value;
    if (message.trim() === "") {
        alert("Please enter a message.");
        return;
    }

    try {
        // Send the log message directly as a string instead of an object
        const response = await axios.post('/api/log', message, {
            headers: {
                'Content-Type': 'text/plain' // Ensure it's sent as plain text
            }
        });
        const logEntries = response.data;
        displayLogEntries(logEntries);
    } catch (error) {
        console.error('Error:', error);
    }
}

function displayLogEntries(entries) {
    const logEntriesDiv = document.getElementById('logEntries');
    logEntriesDiv.innerHTML = '<h2>Last 10 Log Entries:</h2>';
    entries.forEach(entry => {
        logEntriesDiv.innerHTML += `<p><strong>${new Date(entry.timestamp).toLocaleString()}</strong>: ${entry.message}</p>`;
    });
}
