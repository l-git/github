http://www.codinglover.com/cross-browser-styling-placeholder-placeholder-fixed-ie-8-ie-9/






Style Placeholder in different browser
To style placeholder, add the following properties in your css:

::-webkit-input-placeholder {
   font-size: 20px;
}

:-moz-placeholder { /* Firefox 18- */
   font-size: 20px;
}

::-moz-placeholder {  /* Firefox 19+ */
   font-size: 20px;
}

:-ms-input-placeholder {  
   font-size: 20px;
}
You can change the styling based on your need.

 

OH NO! My placeholder not working in IE 8 & IE 9
 Yes, IE 8 and 9 do not support placeholder, but we can add some code to make it work!

$('[placeholder]').focus(function() {
  var input = $(this);
  if (input.val() == input.attr('placeholder')) {
      input.val('');
       input.removeClass('placeholder');
  }
}).blur(function() {
   var input = $(this);
   if (input.val() == '' || input.val() == input.attr('placeholder')) {
	input.addClass('placeholder');
	input.val(input.attr('placeholder'));
   }
}).blur();

$('[placeholder]').parents('form').submit(function() {
  $(this).find('[placeholder]').each(function() {
  var input = $(this);
  if (input.val() == input.attr('placeholder')) {
	input.val('');
  }
})
});
Basically what the code does is it take the value from the placeholder and put it in the value field to make it act like a placeholder. A class placeholder has been added to the input for you to style it. So now let¡¯s get back to the css again to make the change to it.

.placeholder{font-size: 20px;}
Add this line to the end of your css and you¡¯re done! 






















