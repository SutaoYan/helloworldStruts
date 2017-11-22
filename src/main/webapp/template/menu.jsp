<%@ taglib prefix="s" uri="/struts-tags"%>

<li>
	<div>
		<span class="label" style="margin-left: 15px;">
		 <a href="<s:url action=""/>">Categories</a>
		</span>
	</div>
	<ul>
		<li>
			<s:form action="booksByCategoryLink">
				<s:select name="category" list="#session['categoryList']" listValue="categoryDescription" listKey="id" />
				<s:submit value="Select" />
			</s:form>
			<a class="label" href="">
			 <span class="label" style="margin-left: 30px;">
			 </span>
			</a>
		</li>
	</ul>
</li>