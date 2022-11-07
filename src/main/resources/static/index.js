let dlocal = dlocal('db252d4e-4617-48b2-b946-5d5f39cfbcb9');
    let fields = dlocal.fields({
            locale: 'en',
            country: 'BR'
        });

        
    let style = {
        base: {
    // Add your base input styles here. For example:
            fontSize: '16px',
            color: "#32325d",
        }
    };

// Create an instance of the card Field.
    let card = fields.create('card', {style: style});
// Add an instance of the card Field into the `card-field` <div>.
    card.mount(document.getElementById('card-field'));
//Create an cvv field
    let cvv = fields.create('cvv', {style: style})
    cvv.mount(document.getElementById('cvv-field'));
//Create expiration field
    let expiration = fields.create('expiration', {style: style})
    expiration.mount(document.getElementById('expiration-field'))

// Create a token or display an error when the form is submitted.
let form = document.getElementById('payment-form');
form.addEventListener('submit', function(event) {
  event.preventDefault();
  var cardHolderName = document.getElementById('card-holder').value;
  dlocal.createToken(card, {
    name: cardHolderName
  }).then(function(result) {
      // Send the token to your server.
      dlocalTokenHandler(result.token);
  }).catch((result) => {
    if (result.error) {
      // Inform the customer that there was an error.
      var errorField = document.getElementById('card-errors');
      errorField.textContent = result.error.message;
    }
  });
});