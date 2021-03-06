package org.migor.rss.rich.controller

import org.migor.rss.rich.dto.FeedDiscovery
import org.migor.rss.rich.service.SourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


@Controller
class FeedController {

  @Autowired
  lateinit var sourceService: SourceService

  @GetMapping("/")
  fun index(): ModelAndView {
    val mav = ModelAndView("index")
    return mav
  }

//  @GetMapping("/feed:{feedId}/subscribe")
//  fun subscribeToFeed(@PathVariable("feedId") feedId: String): ModelAndView {
//
//    val feed = feedService.findById(feedId)
//
//    val mav = ModelAndView("subscribe")
//    mav.addObject("feedName", "Markus Network")
//    mav.addObject("feedUrl", "foo/bar")
//    return mav
//  }

  @RequestMapping("/user:{ownerEmailHash}/feed/comments/{entryId}/{subscriptionId}",
    method = [RequestMethod.GET],
    produces = [MediaType.TEXT_HTML_VALUE]
  )
  fun comments(@PathVariable("ownerEmailHash") ownerEmailHash: String,
               @PathVariable("entryId") entryId: String,
               @PathVariable("subscriptionId") subscriptionId: String): FeedDiscovery? {
    TODO()
  }

  @GetMapping("/user:{ownerEmailHash}/feed/like/{entryId}/{subscriptionId}")
  fun like(@PathVariable("ownerEmailHash") ownerEmailHash: String,
           @PathVariable("entryId") entryId: String,
           @PathVariable("subscriptionId") subscriptionId: String,
           @RequestParam("commentId", required = false) commentId: String): FeedDiscovery? {
    TODO()
  }

  @RequestMapping("/user:{ownerEmailHash}/feed/read/{entryId}",
    method = [RequestMethod.GET],
    produces = [MediaType.APPLICATION_JSON_VALUE]
  )
  fun read(@PathVariable("ownerEmailHash") ownerEmailHash: String,
           @PathVariable("entryId") entryId: String): FeedDiscovery? {
    TODO()
  }
}
