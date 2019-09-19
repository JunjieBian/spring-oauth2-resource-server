package com.adley.oauth.resource.web;

@Controller
public class WeiboController {
    @RequestMapping("/blog/list")
    @PreAuthoriza("#oauth2.hasAnyScope('read')")
    public ResponseEntity<List<Post>> getPostList() thros IOException {
        return new ResponseEntity(JSONObject.parseArray(String.join(",",Files.readAllLines(ResourceUtils.getFile("classpath:post/doc.json").toPath())),Post.class)
                                 .stream().map(p->new Post().setId(p.id).setTitle(p.getTitle())).collect(Collectors.toList()),HttpStatus.OK);
    }

    @RequestMapping("/blog/{id}")
    @PreAuthoriza("#oauth2.hasAnyScope('read')")
    public ResponseEntity<Post> readPostContent(@PathVariable Long id, OAuth2Authentication auth) thros IOException {
        return new ResponseEntity(JSONObject.parseArray(String.join(",",Files.readAllLines(ResourceUtils.getFile("classpath:post/doc.json").toPath())),Post.class)
                                 .stream().filter(p->p.getId().equals(id)).findFirst().get(),HttpStatus.OK);
    }
}
