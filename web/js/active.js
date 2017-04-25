/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

console.log('active.js loaded');
$(document).ready(function() {
    console.log('jquery-3.2.1.min.js loaded');
    $('input.listen').click(function() {
        alert('You are now listening to the call.');
    });
});