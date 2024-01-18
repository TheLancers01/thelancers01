document.getElementById('deleteAccountForm').addEventListener('submit', function(event) {
    var confirmed = confirm("Are you sure you want to delete your account? This action cannot be undone.");
    if (!confirmed) {
        event.preventDefault();
    }
});
