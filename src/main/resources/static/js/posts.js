(function($){
    $.ajax({'url': '/posts.json'}).done(function(posts){
        var html = '';
        posts.forEach(function(post){
            html += '<div>';
            html += '<h1>'+post.title+'</h1>';
            html += '<p>'+post.body+'</p>';
            html += '<p>Published by ' +post.user.username +'</p>';
            html += '</div>';
        });
        $('#posts').html(html);
    });
})(jQuery);