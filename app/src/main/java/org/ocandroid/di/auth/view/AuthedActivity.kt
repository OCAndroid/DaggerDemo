package org.ocandroid.di.auth.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import org.ocandroid.di.R
import org.ocandroid.di.dagger.component.AuthedComponentHandler
import org.ocandroid.di.databinding.ActivityAuthedBinding
import org.ocandroid.di.detail.view.ItemDetailFragment
import org.ocandroid.di.list.model.Item
import org.ocandroid.di.list.view.ItemListFragment
import org.ocandroid.di.util.Logger
import javax.inject.Inject

private const val ARG_USER_ID_KEY = "user_id_key"
private const val ARG_USER_NAME_KEY = "user_name_key"

@AndroidEntryPoint
class AuthedActivity : AppCompatActivity() {

    @Inject lateinit var logger: Logger
    @Inject lateinit var authedComponentHandler: AuthedComponentHandler
    @Inject lateinit var fragmentFactory: FragmentFactory
    private lateinit var binding: ActivityAuthedBinding

    /*lateinit var authedComponent: AuthedComponent
        private set*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userName = intent.getStringExtra(ARG_USER_NAME_KEY)
        val userId = intent.getStringExtra(ARG_USER_ID_KEY)
        if (userId.isNullOrEmpty() || userName.isNullOrEmpty()) {
            finish()
            return
        }

        /*authedComponent = (application as DIApplication).applicationComponent
            .authedSubcomponent()
            .userId(userId)
            .userName(userName)
            .build()
        authedComponent.inject(this)*/

        authedComponentHandler.auth(userName, userId)

        binding = ActivityAuthedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.fragmentFactory = fragmentFactory

        navigateToList()
    }

    fun navigateToDetails(item: Item) {
        logger.logMessage(this.javaClass.simpleName, "navigateToDetails: $item")
        val args = ItemDetailFragment.createArguments(item.id, item.content)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ItemDetailFragment::class.java, args, ItemDetailFragment::class.java.simpleName)
            .addToBackStack(ItemDetailFragment::class.java.name)
            .commitAllowingStateLoss()
    }

    private fun navigateToList() {
        logger.logMessage(this.javaClass.simpleName, "navigateToList")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ItemListFragment::class.java, null, ItemListFragment::class.java.simpleName)
            .addToBackStack(ItemListFragment::class.java.name)
            .commitAllowingStateLoss()
    }

    companion object {
        fun startActivity(context: Context, userName: String, userId: String) {
            val intent = Intent(context, AuthedActivity::class.java).apply {
                putExtra(ARG_USER_ID_KEY, userId)
                putExtra(ARG_USER_NAME_KEY, userName)
            }
            context.startActivity(intent)
        }
    }
}