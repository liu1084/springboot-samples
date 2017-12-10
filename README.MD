## SPRING redirect
### "redirect:xxx" -- 相对于当前servlet的上下文，
比如当前的上下文是`/user`，那么`redirect:target`，就是302重定向到`/user/target`
当然写绝对地址的话，就会重定向到绝对的某个url地址。
相当于`HttpServletResponse.sendRedirect()`

### "forward:xxx" -- url地址不变，服务器会把当前的请求重新发送给新的url
相当于`RequestDispatcher.forward()`

### 在请求RedirectView过程中，RedirectAttributes可以添加attribute，也可以添加flushAttribute，
attribute会直接跟在url后面，而flushAttribute只能通过@ModelAttribute来接收。

