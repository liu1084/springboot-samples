(function ($) {
    var User = function () {

    };

    User.prototype = {
        init: function () {
            this.bind();
        },
        bind: function () {
            var target = $('#add-user');
            var _this = this;
            $(target).on('click', function () {
                $(target).preventDefault();
                _this.addUser();
            });
        },
        addUser: function () {
            var data = {
                username: $('#username').val()
            };
            $.ajax({
                url: 'http://localhost:8080/user/add',
                data: data,
                type: 'post'
            }).done(function (data) {
                console.log(data)
            }).fail(function (err) {
                console.log(err);
            });
        }
    };

    var user = new User();
    user.init();
})(jQuery);