<%@ taglib prefix = "ex" uri = "/WEB-INF/lang.tld"%>
<script type="text/x-template" id="user-windows-template">  
  <div>
	<user-login-window v-if="showLoginWindow" @close="showLoginWindow = false">    
    <h3 slot="header"><ex:lang message="PLEASE_LOGIN"/></h3>
	<div slot="body">
		<div class="row centered-form">
						<form role="form">
							<div class="form-group">
									<input type="email" name="email" id="email"
										class="form-control input-sm" placeholder="<ex:lang message="EMAIL_ADDRESS"/>">
							</div>

							<div class="form-group">
									<input type="password" name="password" id="password"
										class="form-control input-sm" placeholder="<ex:lang message="PASSWORD"/>">
							</div>
								


							</form>
						</div>		
	</div>
 	<div slot="footer">
             <button class="btn btn-primary" @click="bus.$emit('close-login-window')">
                <ex:lang message="LOGIN"/>
              </button>
				<button class="btn btn-warning" @click="bus.$emit('close-login-window')">
                <ex:lang message="CANCEL"/>
              </button>
    </div>
  </user-login-window>
</div>
</script>